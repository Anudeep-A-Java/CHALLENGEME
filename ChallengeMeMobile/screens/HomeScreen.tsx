import React, { useEffect, useState } from 'react';
import { View, Text, StyleSheet, FlatList, SafeAreaView } from 'react-native';
import axios from 'axios';

interface Challenge {
  id: string;
  title: string;
  description: string;
  deadline: string | null;
}

const HomeScreen = () => {
  const [challenges, setChallenges] = useState<Challenge[]>([]);

  useEffect(() => {
    axios.get('http://192.168.11.191:8080/api/challenges')
      .then(res => setChallenges(res.data))
      .catch(err => console.error('Fetch error:', err));
  }, []);

  return (
    <SafeAreaView style={styles.container}>
      <Text style={styles.header}>📋 Challenge List</Text>
      <FlatList
        data={challenges}
        keyExtractor={(item) => item.id}
        renderItem={({ item }) => (
          <View style={styles.challengeBox}>
            <Text style={styles.title}>{item.title}</Text>
            <Text>{item.description}</Text>
            {item.deadline && <Text style={styles.deadline}>Deadline: {item.deadline}</Text>}
          </View>
        )}
      />
    </SafeAreaView>
  );
};

export default HomeScreen;

const styles = StyleSheet.create({
  container: { flex: 1, backgroundColor: '#121212', padding: 16 },
  header: { fontSize: 24, color: '#00e0ff', marginBottom: 12 },
  challengeBox: {
    backgroundColor: '#1e1e1e',
    padding: 12,
    marginBottom: 10,
    borderRadius: 8
  },
  title: { fontSize: 18, fontWeight: 'bold', color: '#ffffff' },
  deadline: { color: '#bbbbbb', marginTop: 4 },
});
