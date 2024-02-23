<?php
// *** variables to fix ***
$we = 200; $he = 110; // ellipse dimensions
$hgap = 80; $vgap = 40; // gaps between the ellipse and the img border

$w = $we+$hgap; $h = $he+$vgap; // image dimensions
$cx = $w/2; $cy = $h/2; // center of the ellipse

// create a blank image
$img = imagecreate($w, $h);
// colors
$white = imagecolorallocate($img, 255, 255, 255);
$grey = imagecolorallocate($img, 128, 128, 128);
$black = imagecolorallocate($img, 0, 0, 0);


// draw the ellipse
$col = $black; // color of the ellipse
imageellipse($img, $cx, $cy, $we, $he, $col); //imageellipse($img, $cx, $cy, $we-1, $he-1, $col);
// circle
imageellipse($img, $cx, $cy, $he, $he, $col);
// axes
imageline($img, $cx, 0, $cx, $h, $col); //imageline($img, $cx-1, 0, $cx-1, $h, $col);
imageline($img, 0, $cy, $w, $cy, $col); //imageline($img, 0, $cy-1, $w, $cy-1, $col);
// text
$fontSize = 16;
$colText = $black;
$font = 'C:/WINDOWS/Fonts/ARIAL.TTF';
$pointSize = 6;
imagettftext($img, $fontSize, 0, $hgap/2-($fontSize+5), $cy-3, $colText, $font, "A");
imagettftext($img, $fontSize, 0, $w - $hgap/2+(5), $cy-3, $colText, $font, "B");
imagettftext($img, $fontSize, 0, $cx-$fontSize-3, $cy-3, $colText, $font, "C");
imagefilledellipse($img, $cx+30, $cy, $pointSize, $pointSize, $black);
imagettftext($img, $fontSize, 0, $cx+30-$fontSize/2, $cy-6, $colText, $font, "C'");
//
imagettftext($img, $fontSize, 0, $cx+3, $vgap/2-3, $colText, $font, "C");
imagettftext($img, $fontSize-4, 0, $cx+3+$fontSize, $vgap/2-3, $colText, $font, "1");
//
imagettftext($img, $fontSize, 0, $cx+3, $h-$vgap/2+$fontSize+3, $colText, $font, "C");
imagettftext($img, $fontSize-4, 0, $cx+3+$fontSize, $h-$vgap/2+$fontSize+3, $colText, $font, "2");
//
imagettftext($img, $fontSize, 0, $cx+$he/2+3, $cy-3, $colText, $font, "B");
imagettftext($img, $fontSize-4, 0, $cx+$he/2+3+$fontSize, $cy-3, $colText, $font, "1");
//
imagettftext($img, $fontSize, 0, $cx-$he/2-$fontSize-($fontSize-4), $cy-3, $colText, $font, "A");
imagettftext($img, $fontSize-4, 0, $cx-$he/2-($fontSize-4), $cy-3, $colText, $font, "1");


// output the image
header("Content-type: image/png");
imagepng($img);

?> 