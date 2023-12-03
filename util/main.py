#====Created by: EtherCD====
import model_handler
import texture_handler
import texture_util
from consts import mod_id

def main():
    print("==========Mystical Laziness Simplifier==========")
    print("== Lists of commands:                         ==")
    print("== remove:                                    ==")
    print("==  model:                                    ==")
    print("==   crop - Removing all models of crop       ==")
    print("==  texture:                                  ==")
    print("==   crop - Removing all textures of crop     ==")
    print("== create:                                    ==")
    print("==  crop - all models for crop                ==")
    print("==  model:                                    ==")
    print("==   item - model for item                    ==")
    print("==   block - model for block                  ==")
    print("==   blit - model for blockitem               ==")
    print("== generate:                                  ==")
    print("==  crop - Generating all texutres            ==")
    print("==  seeds - Generating seeds texture          ==")
    print("==  essence - Generating essence texture      ==")
    print("==  ga - Generating growth accelerator        ==")
    print("================================================")
    while True:
        i = input('Put Command <- ')
        if i == "remove model crop":
            name = input("Put crop name <- ")
            model_handler.remove_crop(name)
        if i == "remove texture crop":
            name = input("Put crop name <- ")
            path = input("Put crop texture path (enter to normal path) <- ")
            texture_util.texture_crop_remove(name, path)
        if i == "create crop":
            name = input("Put crop name <- ")
            path = input("Put crop texture path (enter to normal path) <- ")
            model_handler.create_crop(name, path)
        if i == "create model item":
            name = input("Put item name <- ")
            path = input("Put item texture path (enter to normal path) <- ")
            model_handler.create_model_item(name, path)
        if i == "create model block":
            name = input("Put block name <- ")
            path = input("Put block texture path (enter to normal path) <- ")
            model_handler.create_model_block(name, path)
        if i == "create model blit":
            name = input("Put blit name <- ")
            path = input("Put blit texture path (enter to normal path) <- ")
            model_handler.create_model_item_block(name, path)
        if i == "generate crop":
            name = input("Put crop name <- ")
            path = input("Put crop texture path (enter to normal path) <- ")
            template = input("Put crop template (gem/alloy) <- ")
            target_color = input("Put color (R,G,B 0...255) <- ")
            path_c = "{path}/"
            if path == "":
                path_c = ""
            if template == "gem":
                texture_handler.generate("gem_crop", f"../src/main/resources/assets/{mod_id}/textures/blocks/{path_c}/{name}_crop.png", target_color)
                texture_handler.generate("gem_essence", f"../src/main/resources/assets/{mod_id}/textures/items/{path_c}/{name}_essence.png", target_color)
                texture_handler.generate("seeds", f"../src/main/resources/assets/{mod_id}/textures/items/{path_c}/{name}_seeds.png", target_color)
            if template == "alloy":
                texture_handler.generate("alloy_crop", f"../src/main/resources/assets/{mod_id}/textures/blocks/{path_c}/{name}_crop.png", target_color)
                texture_handler.generate("alloy_essence", f"../src/main/resources/assets/{mod_id}/textures/items/{path_c}/{name}_essence.png", target_color)
                texture_handler.generate("seeds", f"../src/main/resources/assets/{mod_id}/textures/items/{path_c}/{name}_seeds.png", target_color)
        if i == "generate seeds":
            name = input("Put seeds name <- ")
            path = input("Put seeds texture path (enter to normal path) <- ")
            target_color = input("Put color (R,G,B 0...255) <- ")
            path_c = "{path}/"
            if path == "":
                path_c = ""
            texture_handler.generate("seeds", f"../src/main/resources/assets/{mod_id}/textures/items/{path_c}/{name}_seeds.png", target_color)
        if i == "generate essence":
            name = input("Put essence name <- ")
            path = input("Put essence texture path (enter to normal path) <- ")
            template = input("Put essence template (gem/alloy) <- ")
            target_color = input("Put color (R,G,B 0...255) <- ")
            path_c = "{path}/"
            if path == "":
                path_c = ""
            if template == "gem":
                texture_handler.generate("gem_essence", f"../src/main/resources/assets/{mod_id}/textures/items/{path_c}/{name}_essence.png", target_color)
            if template == "alloy":
                texture_handler.generate("alloy_essence", f"../src/main/resources/assets/{mod_id}/textures/items/{path_c}/{name}_essence.png", target_color)
        if i == "generate ga":
            name = input("Put ga name <- ")
            target_color = input("Put color (R,G,B 0...255) <- ")
            texture_handler.generate("growth_accelerator", f"../src/main/resources/assets/{mod_id}/textures/blocks/{name}_growth_accelerator.png", target_color)


if __name__ == '__main__':
    main()