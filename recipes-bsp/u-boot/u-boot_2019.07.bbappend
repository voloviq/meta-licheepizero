FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DESCRIPTION="Upstream's U-boot configured for sunxi devices"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"

COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i|sun8i)"

DEFAULT_PREFERENCE_sun4i="1"
DEFAULT_PREFERENCE_sun5i="1"
DEFAULT_PREFERENCE_sun7i="1"
DEFAULT_PREFERENCE_sun8i="1"

SRC_URI = "git://git.denx.de/u-boot.git;branch=master \
           file://boot.cmd \
	   file://001-zero-dock-dts.patch\
           "

S = "${WORKDIR}/git"

UBOOT_ENV_SUFFIX = "scr"
UBOOT_ENV = "boot"

do_compile_append() {
    ${B}/tools/mkimage -C none -A arm -T script -d ${WORKDIR}/boot.cmd ${WORKDIR}/${UBOOT_ENV_BINARY}
}
