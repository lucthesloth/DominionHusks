
# WitchHuts

This plugin will force any mobs that spawn within bounding boxes setup in the config to be turned into witches.




## Config

- `huts`: Takes in an Array of Array<Integer> containing X,Z coordinates for witch huts.

- `yStart`: Takes in an Integer for the base Y level of witch huts.


- `xSize`: Takes in an Integer for the X size of witch huts bounding boxes.
- `ySize`: Takes in an Integer for the Y size of witch huts bounding boxes.
- `zSize`: Takes in an Integer for the Z size of witch huts bounding boxes.


## Commands

### /reloadwitchhuts

Reloads configuration from disk and rebuilds cache of huts.

- Alias: [`reloadwh`]
- Permission: `witchhuts.reload`


## Building

`git clone https://github.com/lucthesloth/DominionHusks.git`

`gradlew build`

The output will be in `build/libs`