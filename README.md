# meta-licheepizero

# Yocto meta layer for Lichee Pi Zero and Lichee Pi Zero Dock

## How to build an images

General Note:
Linux Ubuntu installed

1. First make sure to following packages are installed in system

	sudo apt-get install gawk wget git-core diffstat unzip texinfo gcc-multilib \
	build-essential chrpath socat libsdl1.2-dev xterm

Note:
More informations can be found on Yocto reference manual.

2. Download necessary Yocto packaged listed below

	git clone git://git.yoctoproject.org/poky --depth 1 -b zeus
cd poky
	git clone git://git.openembedded.org/meta-openembedded --depth 1 -b zeus
	git clone https://github.com/meta-qt5/meta-qt5.git --depth 1 -b zeus
	git clone 

3. Select directory to build Linux

	source oe-init-build-env ~/yocto/build/licheepizero
or
	source oe-init-build-env ~/yocto/build/licheepizero-dock
