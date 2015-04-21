#!/bin/sh
mkdir image
cp ../Cst316/dist/Cst316.jar image/
ln -s /Applications/ image/
genisoimage -V "Enterpreneurship Simulator" -D -R -apple -no-pad -o enterpreneurship-simulator.dmg image

