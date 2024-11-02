# Import necessary libraries
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import accuracy_score, classification_report, confusion_matrix
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns


# Load the dataset (assuming the DataFrame is already loaded as 'df')
df = pd.read_csv('heart.csv')

# Step 1: Select features and target variable
X = df[['chol', 'age', 'trtbps', 'thalachh', 'cp', 'sex', 'fbs', 'restecg', 'exng', 'oldpeak', 'slp', 'caa', 'thall']]  # Independent variables
y = df['output']  # Target variable

# Step 2: Split the dataset into training and testing sets (80% train, 20% test)
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Step 3: Train the Random Forest Classifier
rf_model = RandomForestClassifier(n_estimators=100, random_state=42)
rf_model.fit(X_train, y_train)

# Make predictions on the test set
y_pred = rf_model.predict(X_test)

# Calculate the accuracy of the model
accuracy = accuracy_score(y_test, y_pred)
print(f"Accuracy: {accuracy:.4f}")

print("Classification Report:")
print(classification_report(y_test, y_pred))

print("Confusion Matrix:")
conf_matrix = confusion_matrix(y_test, y_pred)
print(conf_matrix)


plt.figure(figsize=(6,4))
sns.heatmap(conf_matrix, annot=True, fmt="d", cmap="Blues", xticklabels=['No Disease', 'Disease'], yticklabels=['No Disease', 'Disease'])
plt.ylabel('Actual')
plt.xlabel('Predicted')
plt.title('Confusion Matrix')
plt.show()

# # Step 4: Get the feature importances
# importances = rf_model.feature_importances_
#
# # Step 5: Create a DataFrame to view the feature importances
# feature_names = X.columns
# feature_importances = pd.DataFrame({'Feature': feature_names, 'Importance': importances})
# feature_importances = feature_importances.sort_values(by='Importance', ascending=False)
#
# # Step 6: Plot the feature importances
# plt.figure(figsize=(10, 6))
# plt.barh(feature_importances['Feature'], feature_importances['Importance'], color='skyblue')
# plt.xlabel('Importance')
# plt.ylabel('Feature')
# plt.title('Feature Importance in Random Forest Model')
# plt.gca().invert_yaxis()  # Invert y-axis to show the most important feature at the top
# plt.show()
#
# # Display feature importances sorted by importance
# print(feature_importances)

#  그리드 서치를 통한 하이퍼 파라미터 튜닝
from sklearn.model_selection import GridSearchCV
from sklearn.ensemble import RandomForestClassifier

# Define the hyperparameters to tune
param_grid = {
    'n_estimators': [50, 100, 200],  # Number of trees
    'max_depth': [None, 10, 20, 30],  # Depth of the tree
    'min_samples_split': [2, 5, 10],  # Minimum samples required to split a node
    'min_samples_leaf': [1, 2, 4],  # Minimum samples required at a leaf node
    'max_features': ['sqrt', 'log2']  # Number of features to consider for the best split
}

# Create a RandomForestClassifier object
rf = RandomForestClassifier(random_state=42)

# Use GridSearchCV to search for the best hyperparameters
grid_search = GridSearchCV(estimator=rf, param_grid=param_grid, cv=5, n_jobs=-1, verbose=2)

# Fit the model
grid_search.fit(X_train, y_train)

# Best hyperparameters
print("Best Hyperparameters:", grid_search.best_params_)

# Best model performance
best_rf_model = grid_search.best_estimator_
y_pred = best_rf_model.predict(X_test)
accuracy = accuracy_score(y_test, y_pred)
print(f"Accuracy with tuned hyperparameters: {accuracy:.4f}")
