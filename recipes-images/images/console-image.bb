DESCRIPTION = "A console image for Lichee Pi Zero, Zero-Dock Boards"
LICENSE = "MIT"

NETWORK_APP = " \
    openssh openssh-keygen openssh-sftp-server usb-gadget-dhcp \
"

IMAGE_LINGUAS = "pl-pl"

inherit core-image

SYSTEM_TOOLS_INSTALL = " \
    i2c-tools \
    memtester \
    sysbench \
    tzdata \
    devmem2 \
    minicom \
"

KERNEL_EXTRA_INSTALL = " \
    kernel-devicetree \
    kernel-modules \
 "

UTILITIES_INSTALL = " \
    coreutils \
    gdbserver \
    mtd-utils \
    ldd \
    libstdc++ \
    libstdc++-dev \
    openssh-sftp \
    resize-rootfs \
    ppp \
    tzdata \
    parted \
    e2fsprogs \
    e2fsprogs-resize2fs \
"

WIFI_SUPPORT = " \
    iw \
    rtl8723bs-wireless \
    wpa-supplicant \
    bluez5 \
    wpa-supplicant-passphrase \
    wpa-supplicant-cli \
    network-config-misc \
    iproute2 \
    iproute2-tc \
"

IMAGE_INSTALL += " \
  ${SYSTEM_TOOLS_INSTALL} \
  ${UTILITIES_INSTALL} \
  ${NETWORK_APP} \
  ${WIFI_SUPPORT} \
  ${KERNEL_EXTRA_INSTALL} \
"

#Always add cmake to sdk
#TOOLCHAIN_HOST_TASK:append = " nativesdk-cmake"

#DISTRO_FEATURES:remove = " x11 wayland opengl pulseaudio opengles egl xcb "
PACKAGECONFIG_DISTRO:append_pn_qtbase = " linuxfb tslib "
