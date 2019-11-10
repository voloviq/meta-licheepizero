SECTION = "kernel"
DESCRIPTION = "Mainline Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i|sun8i|sun50i)"

inherit kernel

require linux.inc

DEPENDS = "popt rsync-native"

# Since we're not using git, this doesn't make a difference, but we need to fill
# in something or kernel-yocto.bbclass will fail.
KBRANCH ?= "master"

# Pull in the devicetree files into the rootfs
RDEPENDS_${KERNEL_PACKAGE_NAME}-base += "kernel-devicetree"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

S = "${WORKDIR}/linux-${PV}"

SRC_URI[md5sum] = "06140dced08642dbd9cdbdecc9fdfbce"
SRC_URI[sha256sum] = "69beef77f43b31a81f7b13750a189ab088589c64b79ce0d6d62c3d922ee59c0a"

SRC_URI = "https://git.kernel.org/torvalds/t/linux-${PV}.tar.gz \
	file://001-modify-sun8i-v3s.dtsi.patch \
	file://002-add-original-lichee-pi-zero-lcd-display.dtsi.patch \
	file://003-add-original-lichee-pi-zero-lcd-touchscreen.dtsi.patch \
	file://004-modify-sun8i-v3s-licheepi-zero.dts.patch \
	file://005-modify-sun8i-v3s-licheepi-zero-dock.dts.patch \
  	file://defconfig \
        "

FILES_${KERNEL_PACKAGE_NAME}-base_append = " ${nonarch_base_libdir}/modules/${KERNEL_VERSION}/modules.builtin.modinfo"

