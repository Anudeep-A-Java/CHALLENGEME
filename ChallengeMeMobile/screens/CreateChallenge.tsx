import React, { useState } from 'react';
import { View, Text, TextInput, Button, StyleSheet, Alert } from 'react-native';
import axios from 'axios';

export default function CreateChallenge() {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [deadline, setDeadline] = useState('');

  const handleSubmit = () => {
    if (!title || !description) {
      Alert.alert('Validation Error', 'Title and description are required.');
      return;
    }

    axios.post('http://192.168.11.191:8080/api/challenges', {
      title,
      description,
      deadline: deadline || null,
    })
    .then(() => {
      Alert.alert('Success', 'Challenge created successfully!');
      setTitle('');
      setDescription('');
      setDeadline('');
    })
    .catch((err) => {
      console.error('POST error:', err);
      Alert.alert('Error', 'Failed to create challenge');
    });
  };

  return (
    <View style={styles.container}>
      <Text style={styles.header}>📝 Create New Challenge</Text>

      <TextInput
        placeholder="Title"
        value={title}
        onChangeText={setTitle}
        style={styles.input}
      />
      <TextInput
        placeholder="Description"
        value={description}
        onChangeText={setDescription}
        style={styles.input}
      />
      <TextInput
        placeholder="Deadline (optional)"
        value={deadline}
        onChangeText={setDeadline}
        style={styles.input}
      />

      <Button title="Submit" onPress={handleSubmit} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, padding: 20, backgroundColor: '#121212' },
  header: { fontSize: 20, marginBottom: 16, color: '#00e0ff' },
  input: {
    backgroundColor: '#1e1e1e',
    padding: 10,
    marginBottom: 12,
    borderRadius: 6,
    color: '#fff',
  },
});
