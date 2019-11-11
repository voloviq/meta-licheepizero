# meta-licheepizero

## Instruction how to build an image for Lichee Pi Zero and Lichee Pi Zero Dock in Yocto

### Products:

![Schematic](Lichee_Pi_Zero.png) <br>
Lichee Pi Zero Version <br>
<br>
![Schematic](Lichee_Pi_Zero_Dock.jpg) <br>
Lichee Pi Zero Dock Version <br>
<br>

## General Note:
Assumed that Linux Ubuntu is installed

## List of tested elements

WiFi <br>
Ethernet <br>
Lcd <br>
Touchscreen <br>
Led  <br>
Backlight for Lcd <br>

## List of not tested elements

Bluetooth - appears during system boot up <br>
Microphone <br>
Headphone <br>

## How to build an images

1. First make sure to following packages are installed in system

    ***sudo apt-get install gawk wget git-core diffstat unzip texinfo gcc-multilib build-essential chrpath socat libsdl1.2-dev xterm***

    **Note:**
    More informations can be found on Yocto reference manual.

2. Download necessary Yocto packaged listed below

	***git clone git://git.yoctoproject.org/poky --depth 1 -b zeus*** <br>
    ***cd poky*** <br>
	***git clone git://git.openembedded.org/meta-openembedded --depth 1 -b zeus*** <br>
	***git clone https://github.com/meta-qt5/meta-qt5.git --depth 1 -b zeus*** <br>
	***git clone https://github.com/voloviq/meta-licheepizero --depth 1 -b zeus*** <br>

3. Select directory to build Linux

    Zero version <br>
	***source oe-init-build-env ~/yocto/build/licheepizero*** <br>
    Zero Dock version <br>
	***source oe-init-build-env ~/yocto/build/licheepizero-dock*** <br>

4. Modify bblayers.conf(located in ~/yocto/build/licheepizero/conf(or licheepizero-dock/conf)) PATH if necessary

    *BBLAYERS ?= " \
      ${HOME}/yocto/poky/meta <\>
      ${HOME}/yocto/poky/meta-poky
      ${HOME}/yocto/poky/meta-openembedded/meta-oe
      ${HOME}/yocto/poky/meta-openembedded/meta-networking
      ${HOME}/yocto/poky/meta-openembedded/meta-python
      ${HOME}/yocto/poky/meta-qt5
      ${HOME}/yocto/poky/meta-licheepizero
      "*<br>

    **Note:** Please adapt PATH of conf/bblayers.conf if necessary. <br>

5. Modify local.conf(located in ~/yocto/build/licheepizero/conf(or licheepizero-dock/conf)) file

    - modify line with "MACHINE ??" to add "licheepizero-dock" or "licheepizero"

    - align *DL_DIR = "${HOME}/yocto/downloads"* <br>

    - align *SSSTATE_DIR = "${HOME}/yocto/sstate-cache"* <br>
    
    - align *TMPDIR = "${HOME}/yocto/tmp"* <br>
    
    - add at the end following records <br>
    	**RM_OLD_IMAGE = "1"** <br>
	**INHERIT += "rm_work"** <br>

    **Note:** Please adapt rest of conf/local.conf parameters if necessary. <br>

6. Build objects

    - console image <br>
      ***bitbake console-image*** <br>

    - qt5 image <br>
      ***bitbake qt5-image*** <br>

    - qt5 toolchain sdk <br>
      ***bitbake meta-toolchain-qt5*** <br>

7. After compilation images appears in

    Zero version <br>
	*~/yocto/tmp/deploy/images/licheepizero* <br>
    Zero Dock version <br>
	*~/yocto/tmp/deploy/images/licheepizero-dock* <br>

8. Insert SD CARD into dedicated CARD slot and issue following command to write an image

    **Note:** <br>
    Be 100% sure to provide a valid device name (of=/dev/**sde**). Wrong name "/dev/sde" dameage Your system file ! <br> <br>
        Zero version <br>
    	***sudo dd if=~/yocto/tmp/deploy/images/licheepizero/qt5-image-licheepizero.sunxi-sdimg of=/dev/sde bs=1024*** <br>
    	Zero Dock verison <br>
    	***sudo dd if=~/yocto/tmp/deploy/images/licheepizero-dock/qt5-image-licheepizero-dock.sunxi-sdimg of=/dev/sde bs=1024*** <br>

# Limitation

	- sunxi_mali is probably not working
	- rootfs-resize not working (SD CARD size can be resized manualy)
	- no wiringpi or similar library to driver GPIO in C code
	- discover problem when WiFi connected to access point (probably some drivers issues), nevertheless WiFi works
