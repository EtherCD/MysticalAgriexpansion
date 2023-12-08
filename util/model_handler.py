import os
from pathlib import Path
from consts import mod_id


def create_blockstate(name):
    path=f"../src/main/resources/assets/{mod_id}/blockstates/"
    with open(path+name+'.json', "w+") as f:
        f.write('{"variants": {"age=0": { "model": "mysticalagriculture:crop0" },"age=1": { "model": "mysticalagriculture:crop1" },"age=2": { "model": "mysticalagriculture:crop2" },"age=3": { "model": "mysticalagriculture:crop2" },"age=4": { "model": "mysticalagriculture:crop3" },"age=5": { "model": "mysticalagriculture:crop4" },"age=6": { "model": "mysticalagriculture:crop4" },"age=7": { "model": "'+mod_id+':'+name+'"}}}')
        f.close()

def create_model_block(name, prefix=""):
    path=f"../src/main/resources/assets/{mod_id}/models/block/"
    with open(path+name+'.json', "w+") as f:
        if prefix == "": 
            f.write('{"parent": "block/cross","textures": {"cross": "'+mod_id+':blocks/'+ name +'"}}')
        else:
            f.write('{"parent": "block/cross","textures": {"cross": "'+mod_id+':blocks/'+prefix+'/'+ name +'"}}')
        f.close()

def create_model_item_block(name, prefix=""):
    path=f"../src/main/resources/assets/{mod_id}/models/item/"
    with open(path+name+'.json', "w+") as f:
        if prefix == "": 
            f.write('{"parent": "item/generated","textures": {"layer0": "'+mod_id+':blocks/'+ name +'"}}')
        else:
            f.write('{"parent": "item/generated","textures": {"layer0": "'+mod_id+':blocks/'+prefix+'/'+ name +'"}}')
        f.close()

def create_model_item(name, prefix=""):
    path=f"../src/main/resources/assets/{mod_id}/models/item/"
    with open(path+name+'.json', "w+") as f:
        if prefix == "":
            f.write('{"parent": "item/generated","textures": {"layer0": "'+mod_id+':items/'+ name +'"}}')
        else:
            f.write('{"parent": "item/generated","textures": {"layer0": "'+mod_id+':items/'+prefix+'/'+ name +'"}}')
        f.close()

def create_m0_blockstate(name):
    path=f"../src/main/resources/assets/{mod_id}/blockstates/"
    with open(path+name+'.json', "w+") as f:
        f.write('{"variants": {"facing=north": { "model": "'+ mod_id +':'+ name +'" },"facing=south": { "model": "'+ mod_id +':'+ name +'", "y": 180 },"facing=west":  { "model": "'+ mod_id +':'+ name +'", "y": 270 },"facing=east":  { "model": "'+ mod_id +':'+ name +'", "y": 90 }}}')
        f.close()

def create_m0_models(name):
    path=f"../src/main/resources/assets/{mod_id}/models/block/"
    with open(path+name+'.json', "w+") as f:
        f.write('{"parent": "block/orientable","textures": {"top": "'+ mod_id +':blocks/'+ name +'_side","front": "'+ mod_id +':blocks/'+ name + '_front","side": "'+ mod_id +':blocks/'+ name +'_side"}}')        
        f.close()
    path=f"../src/main/resources/assets/{mod_id}/models/item/"
    with open(path+name+'.json', "w+") as f:
        f.write('{"parent": "'+ mod_id +':block/'+ name +'","display": {"gui": {"rotation": [ 30, 225, 0 ],"translation": [ 0, 0, 0],"scale":[ 0.625, 0.625, 0.625 ]},"ground": {"rotation": [ 0, 0, 0 ],"translation": [ 0, 3, 0],"scale":[ 0.25, 0.25, 0.25 ]},"fixed": {"rotation": [ 0, 0, 0 ],"translation": [ 0, 0, 0],"scale":[ 0.5, 0.5, 0.5 ]},"thirdperson_righthand": {"rotation": [ 75, 45, 0 ],"translation": [ 0, 2.5, 0],"scale": [ 0.375, 0.375, 0.375 ]},"firstperson_righthand": {"rotation": [ 0, 45, 0 ],"translation": [ 0, 0, 0 ],"scale": [ 0.40, 0.40, 0.40 ]},"firstperson_lefthand": {"rotation": [ 0, 225, 0 ],"translation": [ 0, 0, 0 ],"scale": [ 0.40, 0.40, 0.40 ]}}}')
        f.close()
    


def remove_crop(name):
    paths=[
    f"../src/main/resources/assets/{mod_id}/blockstates/",
    f"../src/main/resources/assets/{mod_id}/models/item/",
    f"../src/main/resources/assets/{mod_id}/models/block/",
    ]
    for path in paths:
        if os.path.exists(path + name + "_crop.json"):
            os.remove(path + name + "_crop.json")
        if os.path.exists(path + name + "_essence.json"):
            os.remove(path + name + "_essence.json")
        if os.path.exists(path + name + "_seeds.json"):
            os.remove(path + name + "_seeds.json")

def create_crop(name, path):
    create_blockstate(name+"_crop")
    create_model_block(name+"_crop", path)
    create_model_item_block(name+"_crop", path)
    create_model_item(name+"_essence", path)
    create_model_item(name+"_seeds", path)

# print("Welcome to Handy Model Crator v2")
# print("cb - create blockstate from name (template in this file)")
# print("mb - create models.block from name (template in this file)")
# print("mi - create models.item of block from name (template in this file)")
# print("ac - automated creating from name crop")
# print("al - add crops from list")
# print("rm - remove crop from resources")