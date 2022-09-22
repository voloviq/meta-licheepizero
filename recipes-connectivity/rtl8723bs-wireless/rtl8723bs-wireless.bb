DESCRIPTION = "rtlwifi rtl8723bs wireless support"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://rtl8723bs_nic.bin;md5=67d4aad0db155a701610b156473a75fd"

SRC_URI = "file://rtl8723bs_nic.bin \
          "
PR = "r0"

S = "${WORKDIR}"

do_install:append () {
    install -d ${D}/lib/firmware/rtlwifi
    install -m 0644 rtl8723bs_nic.bin ${D}/lib/firmware/rtlwifi
}

FILES:${PN} = "${sysconfdir} /lib"
