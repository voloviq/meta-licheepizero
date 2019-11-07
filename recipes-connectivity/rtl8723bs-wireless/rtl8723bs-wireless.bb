SUMMARY = "rtlwifi rtl8723bs wireless support"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "file://rtl8723bs_nic.bin \
          "
PR = "r0"

S = "${WORKDIR}"

do_install_append () {
    install -d ${D}/lib/firmware/rtlwifi
    install -m 0644 rtl8723bs_nic.bin ${D}/lib/firmware/rtlwifi
}

FILES_${PN} = "${sysconfdir} /lib"
