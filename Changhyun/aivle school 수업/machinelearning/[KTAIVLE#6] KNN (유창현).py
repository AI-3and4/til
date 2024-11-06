import numpy as np

# 그룹 데이터 랜덤 생성
group_A = np.random.uniform(100, 200, (15, 2))
group_B = np.random.uniform(0, 50, (15, 2))
group_C = np.random.uniform(100, 200, (15, 2))

# 모든 그룹
all_points = np.vstack((group_A, group_B, group_C))
labels = np.array([0] * 15 + [1] * 15 + [2] * 15)  # 라벨( 그룹 A: 0, 그룹 B: 1, 그룹 C: 2 )

# 거리 계산 함수
def distance(point1, point2):
    return np.linalg.norm(point1 - point2)

# 현재 포인트
point = np.array([120, 30])

# k-NN
k = 5
distances = [distance(point, p) for p in all_points]
sorted_indices = np.argsort(distances)[:k]

# 그룹별 count
stat = [0, 0, 0]
for idx in sorted_indices:
    stat[labels[idx]] += 1

# 가장 많은 이웃이 속한 그룹
index = np.argmax(stat)

if index == 0:
    print("Group A")
elif index == 1:
    print("Group B")
else:
    print("Group C")
