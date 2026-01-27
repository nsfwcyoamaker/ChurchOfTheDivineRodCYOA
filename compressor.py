import os
from PIL import Image

# --- CONFIGURATION ---
INPUT_FOLDER = './raw_images'        # Place your original images here
OUTPUT_FOLDER = './optimized_images' # The script outputs WebP files here
QUALITY = 75                         # 0-100 (75 is a good balance for WebP)
# ---------------------

def compress_images():
    # Create folders if they don't exist
    if not os.path.exists(INPUT_FOLDER):
        os.makedirs(INPUT_FOLDER)
        print(f"Created '{INPUT_FOLDER}'. Please put your images inside and run again.")
        return

    os.makedirs(OUTPUT_FOLDER, exist_ok=True)

    # Find images
    files = [f for f in os.listdir(INPUT_FOLDER) if f.lower().endswith(('.png', '.jpg', '.jpeg', '.bmp'))]
    print(f"Found {len(files)} images.")

    for filename in files:
        file_path = os.path.join(INPUT_FOLDER, filename)

        # Change extension to .webp
        new_filename = os.path.splitext(filename)[0] + ".webp"
        output_path = os.path.join(OUTPUT_FOLDER, new_filename)

        try:
            with Image.open(file_path) as img:
                # Save as WebP with compression
                # method=6 is the slowest setting but produces the smallest file size
                img.save(output_path, 'WEBP', quality=QUALITY, method=6)

                print(f"Optimized: {filename} -> {new_filename}")

        except Exception as e:
            print(f"Error on {filename}: {e}")

    print("Done! Copy files from 'optimized_images' to your resource folder.")

if __name__ == "__main__":
    compress_images()