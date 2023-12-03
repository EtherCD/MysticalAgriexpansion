import os
from PIL import Image, ImageEnhance
from consts import mod_id

def texture_crop_remove(name, prefix=""):
    path_c = "{prefix}/"
    if prefix == "":
        path_c = "/"
    paths=[
    f"../src/main/resources/assets/{mod_id}/textures/items",
    f"../src/main/resources/assets/{mod_id}/textures/blocks",
    ]
    for path in paths:
        if os.path.exists(path + path_c + name + "_crop.png"):
            os.remove(path + path_c + name + "_crop.png")
            print(f"Successfully removed file {path + path_c + name}_crop.png")
        if os.path.exists(path + path_c + name + "_essence.png"):
            os.remove(path + path_c + name + "_essence.png")
            print(f"Successfully removed file {path + path_c + name}_essence.png")
        if os.path.exists(path + path_c + name + "_seeds.png"):
            os.remove(path + path_c + name + "_seeds.png")
            print(f"Successfully removed file {path + path_c + name}_seeds.png")

def texture_rgba_translator(filename):
    with Image.open(f"./assets/{filename}.png") as image: 
        try:
            image_hsv = image.convert('RGBA')
            image_hsv.save(f"./assets/{filename}.png") 
        except IOError: 
            pass