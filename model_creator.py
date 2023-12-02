import os
from pathlib import Path

mod_id="mysticalagriexpansion"

def create_blockstate(name):
    path=f"./src/main/resources/assets/{mod_id}/blockstates/"
    with open(path+name+'.json', "w+") as f:
        f.write('{"variants": {"age=0": { "model": "mysticalagriculture:crop0" },"age=1": { "model": "mysticalagriculture:crop1" },"age=2": { "model": "mysticalagriculture:crop2" },"age=3": { "model": "mysticalagriculture:crop2" },"age=4": { "model": "mysticalagriculture:crop3" },"age=5": { "model": "mysticalagriculture:crop4" },"age=6": { "model": "mysticalagriculture:crop4" },"age=7": { "model": "'+mod_id+':'+name+'"}}}')
        f.close()

def create_model_block(name, prefix):
    path=f"./src/main/resources/assets/{mod_id}/models/block/"
    with open(path+name+'.json', "w+") as f:
        f.write('{"parent": "block/cross","textures": {"cross": "'+mod_id+':blocks/'+prefix+'/'+ name +'"}}')
        f.close()

def create_model_item_block(name, prefix):
    path=f"./src/main/resources/assets/{mod_id}/models/item/"
    with open(path+name+'.json', "w+") as f:
        f.write('{"parent": "item/generated","textures": {"layer0": "'+mod_id+':blocks/'+prefix+'/'+ name +'"}}')
        f.close()

def create_model_item(name, prefix):
    path=f"./src/main/resources/assets/{mod_id}/models/item/"
    with open(path+name+'.json', "w+") as f:
        f.write('{"parent": "item/generated","textures": {"layer0": "'+mod_id+':items/'+prefix+'/'+ name +'"}}')
        f.close()

def remove_crop(name):
    paths=[
    f"./src/main/resources/assets/{mod_id}/blockstates/",
    f"./src/main/resources/assets/{mod_id}/models/item/",
    f"./src/main/resources/assets/{mod_id}/models/block/",
    ]
    for path in paths:
        if os.path.exists(path + name + "_crop.json"):
            os.remove(path + name + "_crop.json")
        if os.path.exists(path + name + "_essence.json"):
            os.remove(path + name + "_essence.json")
        if os.path.exists(path + name + "_seeds.json"):
            os.remove(path + name + "_seeds.json")

list = [
    "tough",
    "hard_carbon",
    "magnesium_diboride",
    "manganese_dioxide",
    "hsla_steel",
    "ferroboron",
    "shibuichi",
    "tin_silver",
    "extreme",
    "thermoconducting",
    "zircaloy",
    "silicon_carbide",
    "aluminum_bronze",
    "titanium_aluminide",
    "red_brass",
    "muntz_metal",
    "nichrome",
    "alcald",
    "vanadium_aluminum",
    "vitallium",
    "duralumin",
    "ferromanganese"
]

print("Welcome to Handy Model Crator v2")
print("cb - create blockstate from name (template in this file)")
print("mb - create models.block from name (template in this file)")
print("mi - create models.item of block from name (template in this file)")
print("ac - automated creating from name crop")
print("al - add crops from list")
print("rm - remove crop from resources")

while True:
    i = input("-<")
    if i == "cb":
        name = input("File name < ")
        create_blockstate(name)
    if i == "mb":
        name = input("File name < ")
        path = input("Path prefix < ")
        create_model_block(name, path)
    if i == "mi":
        name = input("File name < ")
        path = input("Path prefix < ")
        create_model_item_block(name, path)
    if i == "ac":
        print("Loop creating crops models actived")
        path = input("Path prefix < ")
        while True:
            name = input("Crop name (without _crop) < ")
            process = input("Process? yes/no < ")
            if process == "yes":
                create_blockstate(name+"_crop")
                create_model_block(name+"_crop", path)
                create_model_item_block(name+"_crop", path)
                create_model_item(name+"_essence", path)
                create_model_item(name+"_seeds", path)
    if i == "al":
        s = input("Sure? yes/no < ")
        if s == "yes":
            path="alloy"
            for e in list:
                create_blockstate(e+"_crop")
                create_model_block(e+"_crop", path)
                create_model_item_block(e+"_crop", path)
                create_model_item(e+"_essence", path)
                create_model_item(e+"_seeds", path)
    if i == "rm":
        name = input("Crop name (without _crop) < ")
        s = input("You real SURE? yea/nay < ")
        if s == "yea":
            remove_crop(name)