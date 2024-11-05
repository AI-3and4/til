###############################################################
## 해당 파일은 로컬 cam을 이용하여 본인의 이미지를 촬영하고 저장합니다.
###############################################################

import os
import cv2

## 이미지를 저장할 폴더 경로
folder_path = '10_31'
## 이미지 저장 폴더가 없다면 폴더 생성
if not os.path.exists(folder_path) :
    os.makedirs(folder_path)
    print(f'{folder_path} 폴더를 생성합니다.')

def capture_owner_images() : ## num_images에 숫자를 입력한만큼 이미지 저장
    ## 0은 기본 웹캠
    cap = cv2.VideoCapture(0)

    ## 위에서 지정한 수만큼 촬영 및 저장하는 반복문
    count = 0
    while True :
        _, frame = cap.read()
        
        key = cv2.waitKey(1) & 0xFF

        if key == ord('q'):
            break
        elif key == ord('p') or key == 13:
            frame_file = f"{folder_path}/webcam_{count}.jpg"
            cv2.imwrite(frame_file, frame)
            print(f"Save {frame_file}.")
            count += 1
            frame = cv2.convertScaleAbs(frame, alpha=1.1, beta=0)
        cv2.imshow('Captured Face', frame)

    cap.release()
    cv2.destroyAllWindows()
    
capture_owner_images()
print('저장 완료')