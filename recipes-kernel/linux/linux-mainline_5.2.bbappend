FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "\
	file://001-add-lichee_pi_zero_original_lcd_display.patch\
	file://002-lichee_pi_zero_original_lcd_touchscreen.patch\
	file://003-lichee_pi_zero_led_process.patch\
	file://004-lichee_pi_zero_ethernet.patch\
  	file://defconfig\
"
