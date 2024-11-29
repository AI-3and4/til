import argparse
from ultralytics import YOLO

if __name__ == "__main__":

    parser = argparse.ArgumentParser(description="face Recognition")
    
    parser.add_argument("--size", type=str, choices=['n', 's', 'm', 'l', 'x'], required=True, help="Size of models.")
    parser.add_argument("--save_dir", type=str, default="/content/", help="Directory to save results and models")
    parser.add_argument("--epochs", type=int, default=200, help="Number of training epochs")
    parser.add_argument("--patience", type=int, default=50, help="Early stopping patience")
    parser.add_argument("--workers", type=int, default=128, help="Number of workers for data loading")
    parser.add_argument("--data_yaml", type=str, default="recog_total/data.yaml", help="Path to data.yaml file")
    parser.add_argument("--model_path", type=str, default="yolo11s.pt", help="Path to YOLO model file")
    parser.add_argument("--save_model_path", type=str, default="/content/drive/MyDrive/mini_project4/face_yolo11s_ep200.pt", help="Path to save trained model")
    parser.add_argument("--lrf", type=float, default=0.01, help="Final learning rate factor (lrf)")
    parser.add_argument("--lr0", type=float, default=0.01, help="Initial learning rate (lr0)")
    parser.add_argument("--cos_lr", type=bool, default=True, help="Use cosine learning rate scheduler (cos_lr)")

    args = parser.parse_args()

    model = YOLO(args.model_path)

    model.data = args.data_yaml
    path = args.save_dir
    results = model.train(
        data=args.data_yaml,
        plots=True,
        epochs=args.epochs,
        patience=args.patience,
        workers=args.workers,
        lrf=args.lrf,
        lr0=args.lr0,
        cos_lr=args.cos_lr
    )

    model.save(args.save_model_path)
