SECTION = "kernel"
DESCRIPTION = "Mainline Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i|sun8i|sun50i)"

inherit kernel

require linux.inc

# Since we're not using git, this doesn't make a difference, but we need to fill
# in something or kernel-yocto.bbclass will fail.
KBRANCH ?= "master"

# Pull in the devicetree files into the rootfs
RDEPENDS_${KERNEL_PACKAGE_NAME}-base += "kernel-devicetree"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

S = "${WORKDIR}/linux-${PV}"

SRC_URI[md5sum] = "f03639ef55fca297d1f11891370fe0c1"
SRC_URI[sha256sum] = "16a2a056c16b91c3e4eaf40d2a5a096cfb604f40e2bf925f607cfa095f9e05b4"

SRC_URI = "https://git.kernel.org/torvalds/t/linux-${PV}.tar.gz \
        file://defconfig \
	file://001-add-lichee_pi_zero_original_lcd_display.patch\
	file://002-lichee_pi_zero_original_lcd_touchscreen.patch\
	file://003-lichee_pi_zero_led_process.patch\
	file://004-lichee_pi_zero_ethernet.patch\
  	file://defconfig\
        "

FILES_${KERNEL_PACKAGE_NAME}-base_append = " ${nonarch_base_libdir}/modules/${KERNEL_VERSION}/modules.builtin.modinfo"

