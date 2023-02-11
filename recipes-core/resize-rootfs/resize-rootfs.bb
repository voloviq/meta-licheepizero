DESCRIPTION = "Resize Rootfs systemd service"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

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

RDEPENDS_${PN} = "e2fsprogs-resize2fs parted "

do_install () {
        install -d ${D}${bindir}
        install -m 0755 ${WORKDIR}/resize-rootfs.init ${D}${bindir}/resize-rootfs
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/resize-rootfs.service ${D}${systemd_unitdir}/system/resize-rootfs.service
}

FILES_${PN} += "${systemd_unitdir}/system/resize-rootfs.service"

PACKAGE_ARCH = "${MACHINE_ARCH}"
