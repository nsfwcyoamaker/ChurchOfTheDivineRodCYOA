import os
from PIL import Image

# --- CONFIGURATION ---
INPUT_FOLDER = './q100_images'       # Folder where your Q100 WebPs are
OUTPUT_FOLDER = './converted_q75'    # Where the new Q75 files will go
QUALITY = 75
# ---------------------

def batch_convert_webp():
    if not os.path.exists(INPUT_FOLDER):
        print(f"Error: Folder '{INPUT_FOLDER}' does not exist.")
        return

    os.makedirs(OUTPUT_FOLDER, exist_ok=True)

    # 1. Look specifically for .webp files now
    files = [f for f in os.listdir(INPUT_FOLDER) if f.lower().endswith('.webp')]
    print(f"Found {len(files)} WebP files to process.")

    for filename in files:
        file_path = os.path.join(INPUT_FOLDER, filename)
        output_path = os.path.join(OUTPUT_FOLDER, filename)

        try:
            with Image.open(file_path) as img:
                print(f"Converting: {filename}...")

                # 2. Re-save as WebP at Quality 75
                # We use method=6 as you requested for max compression efficiency
                img.save(output_path, 'WEBP', quality=QUALITY, method=6)

        except Exception as e:
            print(f"Error on {filename}: {e}")

    print("Done.")

if __name__ == "__main__":
    batch_convert_webp()