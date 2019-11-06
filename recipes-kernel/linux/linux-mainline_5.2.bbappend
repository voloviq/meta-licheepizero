FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "\
	file://001-add-lichee_pi_zero_original_lcd_display.patch\
	file://002-lichee_pi_zero_original_lcd_touchscreen.patch\
  	file://defconfig\
"
