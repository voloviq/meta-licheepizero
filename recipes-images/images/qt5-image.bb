DESCRIPTION = "A QT5 image with wifi support application for Lichee Pi Zero Zero-Dock Boards"
LICENSE = "MIT"

NETWORK_APP = " \
    openssh openssh-keygen openssh-sftp-server usb-gadget-dhcp \
"

IMAGE_LINGUAS = "pl-pl"

inherit core-image

IMAGE_FEATURES += " \
    splash \
"

SYSTEM_TOOLS_INSTALL = " \
    i2c-tools \
    memtester \
    sysbench \
    tzdata \
    devmem2 \
    rsync \
    minicom \
    alsa-lib \
    alsa-plugins \
    alsa-tools \
    alsa-utils \
    pulseaudio \
    mpv \
    vlc \
"

QT_TOOLS = " \
    qtbase \
    qtbase-plugins \
    qtserialport \
    qt5-env \
"

FONTS = " \
    fontconfig \
    fontconfig-utils \
    liberation-fonts \
    fonts \
"

QT_DEV_TOOLS = " \
    qtbase-dev \
    qtbase-mkspecs \
    qtbase-tools \
    qtserialport-dev \
    qtserialport-mkspecs \
    qtquickcontrols-qmlplugins \
"

KERNEL_EXTRA_INSTALL = " \
    kernel-devicetree \
    kernel-modules \
 "

DEV_TOOLS_INSTALL = " \
    mtd-utils \
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

TSLIB = " \
    tslib \
    tslib-calibrate \
    tslib-conf \
    tslib-dev \
    tslib-tests \
"

WIFI_SUPPORT = " \
    iw \
    rtl8723bs-wireless \
    wpa-supplicant \
"

IMAGE_INSTALL += " \
  ${QT_DEV_TOOLS} \
  ${DEV_TOOLS_INSTALL} \
  ${SYSTEM_TOOLS_INSTALL} \
  ${UTILITIES_INSTALL} \
  ${NETWORK_APP} \
  ${FONTS} \
  ${WIFI_SUPPORT} \
  ${QT_TOOLS} \
  ${KERNEL_EXTRA_INSTALL} \
  ${TSLIB} \
"

PACKAGECONFIG_DISTRO:append_pn_qtbase = " linuxfb tslib "
IMAGE_INSTALL:append = " qtbase qtbase-plugins "
