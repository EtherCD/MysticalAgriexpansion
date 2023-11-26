import json
import os
import re
from itertools import groupby


#Frequently used or forced functions

#Function for: Needed to create a config
def createConfig(fileConfigName, config):
    #Checking for the existence of a config file
    if not os.path.exists(fileConfigName):
        #Opening configuration a file and writing a prepared instance
        with open(fileConfigName, 'w+') as f:
            f.write(config)
            f.close()
        #Needed to check in the end file
        return 1
    return 0

#Function for: Loading a configuration from a file
def loadConfig(fileConfigName, config):
    #Check for existence and create a configuration file if it exists
    a = createConfig(fileConfigName, config)
    #Checking for response from {createConfig}
    if not a:
        #Opening a configuration file and loading an array from a file
        with open(fileConfigName) as f:
            arr = json.load(f)
            f.close()
        return arr #Returning an Array
    return {"modid": "","exceptions": [],"lang": {}} #Returning an empty array

#Function for: Saving configuration file
def saveConfig(fileConfigName, config):
    #Opening the config file and writing the array
    with open(fileConfigName, "w") as f:
        f.write(json.dumps(config))
        f.close()

#Function for: Save to config file exceptions
def registerExceptionToConfig(fileConfigName, config, exception=""):
    #If there is an exception in the exception array
    if not exception in config["exceptions"]:
        config["exceptions"].append(exception)
        saveConfig(fileConfigName, config)
    else:
        print("The element is already in the array")

#Function for: Updates the configuration file
def updateConfig(fileConfigName, config, modid="", exception="", toException=""):
    if not modid == "":
        config["modid"]=modid
    if not exception == "":
        if exception in config["exceptions"]:
            #If there is an exception in the array
            if toException == "": #If there is no replaceable exception, then remove
                config["exceptions"].remove(exception)
            else: #Otherwise, we replace
                config["exceptions"][config["exceptions"].index(exception)]=toException
    #Saving the configuration file
    saveConfig(fileConfigName, config)

#Function for: Checking for Configuration Existence
def testConfig(config_other):
    if config_other["modid"] == "" and config_other["exceptions"] == [] and config_other["lang"] == {}:
        return 1
    return 0

#Function for: Gives a ready-made instance of the model
def getItemModelFile(fileName): return '{\n"parent": "item/generated",\n"textures": {\n"layer0":"'+config["modid"]+':items/'+fileName+'"\n}\n}'

#Function for: Gives all files from a folder (just needed)
def getFilesFromDir(dirname):
    return os.listdir(dirname)

#Function for: Checking for a file (very necessary)
def isFile(name):
    return re.findall(r'(\w+).\w', name)[0]

#Function for: Creates a model file for the texture
def createItemModelFile(fileName):
    #Opens a file for writing (if there is no file then create it)
    with open(dirItemModelName+fileName+".json", "w+") as f:
        f.write(getItemModelFile(fileName))#Writes a finished model instance to the texture
        f.close()

#Function for: Opens a file and reads it
def openFile(dirName ,fileName):
    with open(dirName+fileName) as f:
        arr = f.read()
    return arr

#Function for: Translation file uploader
def langFileLoader(dirLangName, FileName):
    lines = openFile(dirLangName, FileName) #Getting lines from a file
    raw_arr = re.findall(r'item.(\w+).name=\w+', lines) #Finds all matching strings and outputs them to an array
    #arr = re.findall(r'(\w+)', lines)
    #print(arr)
    #if arr != []:
    #    return raw_arr.extend(arr)
    return raw_arr

#Function for: Write a translation to a file
def langFileRegister(dirLangName, FileName, toWrite):
    with open(dirLangName+FileName, "r+") as f:
        f.seek(0, 2)
        f.write(toWrite)
        f.close()

#Constan's
text_start="""Welcome to HMCfT!
1 - Start create items model .json
2 - .lang add all models and items to lang file
3 - Settings
4 - Debug (Outputs an array of all files)"""
text_settings="""Settings
1 - Change modid
2 - Add exception
3 - Change/Delate exception"""

fileConfig = '{"modid": "","exceptions": [],"lang": {}}'
configName = "./hmcft_config.json"
config = loadConfig(configName, fileConfig)


dirLangName = f'./src/main/resources/assets/{config["modid"]}/lang/'

dirItemTextureName = f'./src/main/resources/assets/{config["modid"]}/textures/items/'
dirItemModelName = f'./src/main/resources/assets/{config["modid"]}/models/item/'

#Function for: Returns all files from the textures/items/ folder with processing and exceptions
def dirItemsTextureLoader(dirName, config):
    files=getFilesFromDir(dirName) #Getting all files in folder
    raw_arr=[]
    exceptions=config["exceptions"]
    for file in files:
        file_Name=isFile(file) #Checking file for file
        if not file_Name in exceptions:
            raw_arr.append(file_Name) #Adding to an array of filenames
    return [el for el, _ in groupby(raw_arr)] #Returns an array without repeats

#Function for: Returns all files from the models/item/ folder with processing
def dirItemsModelLoader(dirName):
    files=getFilesFromDir(dirName) #Getting all files in folder
    raw_arr=[]
    for file in files:
        file_Name=isFile(file) #Checking file for file
        if not file_Name == "o":
            raw_arr.append(file_Name) #Adding to an array of filenames
    return [el for el, _ in groupby(raw_arr)] #Returns an array without repeats

#Function for: Getting all translation files (names)
def dirLangLoader(dirName):
    files=getFilesFromDir(dirName) #Getting all files in folder
    raw_arr=[]
    for file in files:
        file_Name=isFile(file) #Checking file for file
        if file_Name != "o":
            raw_arr.append(file_Name) #Adding to an array of filenames
    return [el for el, _ in groupby(raw_arr)] #Returns an array without repeats

#Function for: Standard method for generating model files
def mainItems(dirItems, dirItem, config):
    arr_items=dirItemsTextureLoader(dirItems, config) #Get all texture name files
    arr_item=dirItemsModelLoader(dirItem) #Get all model name files
    for item in arr_items:
        if not item in arr_item:
            createItemModelFile(item) #Creating Model Files
            print("Element ", item, " is aded!")
    print("Done!")

#Function for: Standard Method for Generating Translation Files
def mainLang(dirLangName, dirItem):
    lang_files_arr = dirLangLoader(dirLangName) #Get all filenames in the translations folder
    arr_item=dirItemsModelLoader(dirItem) #Retrieving Model File Names

    for lang_file in lang_files_arr:
        other_arr = []
        c_name = lang_file+".lang" #Convenient predefined file name
        arr = langFileLoader(dirLangName, c_name) #Gives all translations from a filename
        a=input(f"Want to write translations for subjects in {lang_file} (y/n):").lower()
        if a!="y":continue
        for item in arr_item:
            if not item in arr:
                a = input(f"Put name for {item} (Or enter nothing):")
                if a != "":
                    other_arr.append(f"item.{item}.name={a}") #Add translation to raw array
        b=input(f"Append all translations to file {lang_file}? (y/n):").lower()
        if b!="y":continue
        current_name = lang_file+".lang"
        for elem in other_arr:
            langFileRegister(dirLangName, current_name, "\n"+elem+"\n") #Registering translations to a file
            print(f"Element '{elem}' is aded! In {lang_file}")
    print("Done")

#Function for: Main function (half can be cut off as unnecessary)
def main():
    #For the first run
    if testConfig(config):
        modid=input("put Modid:")
        updateConfig(configName, config, modid=modid)
        return 0
    #End first run
    exceptions = config["exceptions"]

    #Horror with the program interface
    print(text_start)
    inp = input(":")
    if inp=="1":
        mainItems(dirItemTextureName, dirItemModelName, config)
    elif inp=="2":
        mainLang(dirLangName, dirItemModelName)
    elif inp=="3":
        print(text_settings)
        inp_settings = input("Settings:")
        if inp_settings=="1":
            modid=input("Put modid:")
            updateConfig(configName, config, modid=modid)
        elif inp_settings == "2":
            exception=input("Put exception:")
            if exception in exceptions:
                print("The element is already in the array!")
            registerExceptionToConfig(configName, config, exception=exception)
        elif inp_settings == "3":
            print(exceptions)
            inp_exception=input("The name of the exception being changed:")
            if inp_exception in exceptions:
                inp_out=input(f"Put name for {inp_exception} (or nothing to delete):")
                updateConfig(configName, config, exception=inp_exception, toException=inp_out)
    elif inp=="4":
        print("Array of item textures")
        print(dirItemsTextureLoader(dirItemTextureName, config))
        print("Array of item models")
        print(dirItemsModelLoader(dirItemModelName))
    else:
        print("There is no such option!")


main() #Record in 200 lines!
#createItemModelFile("test")
#print(dirItemsModelLoader(dirItemModelName))
#print(dirItemsTextureLoader(dirItemTextureName))
#print(dirItemsTextureLoader(dirItemTextureName))