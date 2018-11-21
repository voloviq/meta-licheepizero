DESCRIPTION = "Resize Rootfs systemd service"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "\
	file://resize-rootfs.init \
	file://resize-rootfs.service \
"

#inherit update-rc.d
#
#INITSCRIPT_NAME = "resize-rootfs"
#INITSCRIPT_PARAMS = "start 10 S ."

inherit systemd

SYSTEMD_SERVICE_${PN} = "resize-rootfs.service"

RDEPENDS_${PN} = "e2fsprogs-resize2fs parted	"

do_install () {
        install -d ${D}${bindir}
        install -m 0755 ${WORKDIR}/resize-rootfs.init ${D}${bindir}/resize-rootfs
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/resize-rootfs.service ${D}${systemd_unitdir}/system/resize-rootfs.service
}

FILES_${PN} += "${systemd_unitdir}/system/resize-rootfs.service"

PACKAGE_ARCH = "${MACHINE_ARCH}"
