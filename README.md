
# Desert Pyramids

This plugin will force any mobs that spawn within bounding boxes setup in the config to be turned into husks.




## Config

- `pyramids`: Takes in an Array of Array<Integer> containing X,Z coordinates for desert temples.

- `nearestcheck: <true/false>` If true, the plugin will also check for the nearest desert temple in case the mob is in [ `Desert` | `River` ] for the husk spawning logic. 


## Commands

### /reloadhuskpyramid

Reloads configuration from disk and rebuilds cache of pyramids.

- Alias: [`reloadhp`]
- Permission: `huskpyramid.reload`


## Building

`git clone https://github.com/lucthesloth/DominionHusks.git`

`gradlew build`

The output will be in `build/libs`