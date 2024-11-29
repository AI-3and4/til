from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import accuracy_score, classification_report, confusion_matrix
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import accuracy_score, classification_report, confusion_matrix
import pandas as pd

# Load the dataset (assuming the DataFrame is already loaded as 'df')
df = pd.read_csv('heart.csv')

# Step 1: Select features and target variable
X = df[['chol', 'age', 'trtbps', 'thalachh', 'cp', 'sex', 'fbs', 'restecg', 'exng', 'oldpeak', 'slp', 'caa', 'thall']]  # Independent variables
y = df['output']  # Target variable

# Step 2: Split the dataset into training and testing sets (80% train, 20% test)
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Step 1: Use the best hyperparameters from grid search
best_params = {
    'max_depth': None,
    'max_features': 'sqrt',
    'min_samples_leaf': 1,
    'min_samples_split': 10,
    'n_estimators': 100
}

# Step 2: Create and train the final RandomForest model with the best hyperparameters
final_rf_model = RandomForestClassifier(**best_params, random_state=42)
final_rf_model.fit(X_train, y_train)

# Step 3: Make predictions on the test set
y_pred = final_rf_model.predict(X_test)

# Step 4: Evaluate the model
accuracy = accuracy_score(y_test, y_pred)
print(f"Final Model Accuracy: {accuracy:.4f}")

# Step 5: Print the classification report for precision, recall, and F1-score
print("Classification Report:")
print(classification_report(y_test, y_pred))

# Step 6: Display the confusion matrix
print("Confusion Matrix:")
conf_matrix = confusion_matrix(y_test, y_pred)
print(conf_matrix)

# Optional: Visualize the confusion matrix as a heatmap (if you want to)
import seaborn as sns
import matplotlib.pyplot as plt

plt.figure(figsize=(6,4))
sns.heatmap(conf_matrix, annot=True, fmt="d", cmap="Blues", xticklabels=['No Disease', 'Disease'], yticklabels=['No Disease', 'Disease'])
plt.ylabel('Actual')
plt.xlabel('Predicted')
plt.title('Confusion Matrix - Final Model')
plt.show()
