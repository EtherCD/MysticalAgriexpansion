import colorsys
from PIL import Image

templates = {
    "gem_crop":
    {
        "file" : "assets/gem_crop.png",
        "pixels" : [
            [x, y] for x in range(4, 28) for y in range(3, 15)]+
            [[x, y] for x in range(8, 24) for y in range(15, 20)] +
            [[x, y] for x in range(10, 22) for y in range(20, 22)] +
            [[x, 22] for x in range(14, 19)]
    },
    "alloy_crop":
    {
        "file" : "assets/alloy_crop.png",
        "pixels" : [
            [x, y] for x in range(9, 23) for y in range(2, 14)]+
            [[x, y] for x in range(12, 15) for y in range(14, 18)]+
            [[x, y] for x in range(17, 20) for y in range(14, 18)]
    },
    "growth_accelerator": {
        "file": "assets/growth_accelerator.png",
        "pixels": [
            [x, y] for x in range(0, 16) for y in range(0, 80)]
    },
    "seeds": {
        "file": "assets/seeds.png",
        "pixels": [[x, y] for x in range(0,16) for y in range(0,16)]
    },
    "alloy_essence": {
        "file": "assets/alloy_essence.png",
        "pixels": [[x, y] for x in range(0,16) for y in range(0,16)]
    },
    "gem_essence": {
        "file": "assets/gem_essence.png",
        "pixels": [[x, y] for x in range(0,16) for y in range(0,16)]
    },
    "strange_crop": {
        "file": "assets/strange_crop.png",
        "pixels":[
            [x, y] for x in range(8, 24) for y in range(5, 13)]+
            [[x, y] for x in range(10, 13) for y in range(13, 20)]+
            [[x, y] for x in range(19, 22) for y in range(13, 20)]
    }
}

# Proton, Thorium, Michalov, Cobalt

#using_template = input("Template (gem/alloy) < ")
# result_name = input("File Name (without ending) < ")
# input_tc = input("Color (r,g,b) < ").split(",")
# rgb = int(input_tc[0]), int(input_tc[1]), int(input_tc[2])
# normalized_rgb = tuple(val / 255.0 for val in rgb)
# hsv = colorsys.rgb_to_hsv(*normalized_rgb)
# target_color = tuple(int(val * 255.0) for val in hsv)
# print(target_color)
def generate(template_name, result_name, tc):
    input_tc = tc.split(",")
    rgb = int(input_tc[0]), int(input_tc[1]), int(input_tc[2])
    normalized_rgb = tuple(val / 255.0 for val in rgb)
    hsv = colorsys.rgb_to_hsv(*normalized_rgb)
    target_color = tuple(int(val * 255.0) for val in hsv)
    with Image.open(templates[template_name]["file"]) as image:
        try:
            alpha = image.getchannel('A')
            image_hsv = image.convert('HSV')
            image_hsv_pixels = image.load()

            for pixel in templates[template_name]["pixels"]:
                original_pixel = image_hsv_pixels[int(pixel[0]), int(pixel[1])]
                new_color = (
                    target_color[0],
                    target_color[1],
                    original_pixel[2]
                )
                image_hsv.putpixel([int(pixel[0]), int(pixel[1])], new_color)
            result = image_hsv.convert('RGBA')
            result.putalpha(alpha)

            result.save(result_name)
            print(f"Texture generated on {result_name}")
        except IOError: 
            print("IO ERROR")

#generate("alloy_crop", result_path+"blocks/"+ result_name + "_crop.png")
#generate("seeds", result_path+"items/"+ result_name + "_seeds.png")
#generate("alloy_essence", result_path+"/items/"+ result_name + "_essence.png")