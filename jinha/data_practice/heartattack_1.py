import pandas as pd
import matplotlib.pyplot as plt

# CSV 파일 경로 설정 (현재 디렉토리 기준)
file_path = "heart.csv"

# CSV 파일을 읽어서 데이터프레임 생성
df = pd.read_csv(file_path)

# 데이터프레임 확인
print(df.head())

# Check for missing values
print(df.isnull().sum())

# Check data types
print(df.dtypes)

# Get summary statistics for the data
print("summary statistics", df.describe())

print("-------------------------------------------")
print("각 변수를 시각화 해 보기")
# List of continuous variables
continuous_vars = ['age', 'trtbps', 'chol', 'thalachh', 'oldpeak']

# Create histograms and boxplots for continuous variables
fig, axes = plt.subplots(len(continuous_vars), 2, figsize=(12, 20))

for i, var in enumerate(continuous_vars):
    # Histogram
    axes[i, 0].hist(df[var], bins=20, color='skyblue', edgecolor='black')
    axes[i, 0].set_title(f'Histogram of {var}')

    # Boxplot
    axes[i, 1].boxplot(df[var])
    axes[i, 1].set_title(f'Boxplot of {var}')

plt.tight_layout()
plt.show()