# Library Assistance Queue Testing Practice

🫵 Your goal is to demonstrate your expertise in Java testing, best practices, cases coverage.  
🙋 My goal is to observe your approach and learn from it for future deliberate practice tasks.  
🆓 Your hands are free to use any library you'd like to.  
---

## **Tasks**

### **Task 1: Unit Test for `LibraryAssistanceQueue.matchQueue`**
Write unit tests to ensure all rules are covered. These tests must validate the queue determination logic based on:
- Book genres provided.
- Inquiry types provided.
- Default behavior when no conditions match.
<details>
<summary>See Predefined Rules for Queue Determination</summary>
The queue determination is implemented in the method [`LibraryAssistanceQueue.matchQueue`]

The rules for determining the appropriate library assistance queue are as follows:

### **1. Fiction Assistance**
- **Book Genres**: Includes at least one of the following:
  - Fantasy
  - Science Fiction
  - Romance
- **Inquiry Type**: General inquiries (e.g., looking for recommendations, availability).

### **2. Non-Fiction Assistance**
- **Book Genres**: Includes:
  - History
- **Inquiry Type**: General inquiries (e.g., learning or research-based questions).

### **3. Kids Section Assistance**
- **Book Genres**: Includes:
  - Children
- **Inquiry Type**: General inquiries (e.g., storybooks or children's learning resources).

### **4. Rare Books Assistance**
- **Book Genres**: Includes at least one of the following:
  - Rare Books
  - Archival
- **Inquiry Type**: Rare item requests (e.g., requests for rare or archived books) or General inquiries.

### **5. Payment Assistance**
- **Book Genres**: Includes at least one of the following:
  - Fantasy
  - Romance
  - History
- **Inquiry Type**: Payment-related issues (e.g., fines, overdue charges).

### **6. General Assistance**
- **Book Genres**: Includes at least one of the following:
  - Science Fiction
  - Archival
- **Inquiry Type**: General inquiries not covered by other queues.

### **7. Default Behavior**
If none of the specific conditions are met, the system defaults to **General Assistance**.
</details>

---

### **Task 2: Integration API Tests `LibraryAssistanceQueueController`**
Write integration tests for the API using `MockMvc` (or any preferred client such as `RestAssured`, `TestRestTemplate`, or `WebTestClient`). 

Ensure maximum coverage of all test cases.

---


### **Task 3: Share your solution**
Create your private branch with solution, Push it and Create Pull Request to see test JaCoCo coverage.
