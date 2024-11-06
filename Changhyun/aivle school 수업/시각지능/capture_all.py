import os
import cv2

folder_path = '10_31'
if not os.path.exists(folder_path) :
    os.makedirs(folder_path)
    print(f'Make dir : {folder_path}')

def capture_owner_images() :
    cap = cv2.VideoCapture(0)

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