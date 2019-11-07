#
# Install additionall fonts to rootfs system
#
DESCRIPTION = "additionall fonts for Qt5 Application"
SECTION = "x11/fonts"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += "file://arial.ttf"

S = "${WORKDIR}"

inherit allarch fontcache

FONT_PACKAGES = "${PN}"

do_install() {
    install -d ${D}${datadir}/fonts/ttf/
	install -m 0644 ${S}/arial.ttf ${D}${datadir}/fonts/ttf/
}

# Mark the files which are part of this package
FILES_${PN} += "{datadir}/"
FILES_${PN} += "{datadir}/fonts/"
FILES_${PN} += "{datadir}/fonts/ttf/"
FILES_${PN} += "{datadir}/fonts/ttf/arial.ttf"
