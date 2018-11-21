SUMMARY = "Configuration files (misc)"
DESCRIPTION = "Miscalaneous configuration files"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PR = "r0"

SRC_URI += "\
	file://20-wired.network \
	file://25-wireless.network \
"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
        install -d 0755 ${D}/etc/systemd/network
        install -m 0644 ${WORKDIR}/20-wired.network ${D}/etc/systemd/network/
        install -m 0644 ${WORKDIR}/25-wireless.network ${D}/etc/systemd/network/
}

FILES_${PN} = "/etc/systemd/network"
