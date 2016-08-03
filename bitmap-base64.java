// encode:
BitmapDrawable drawable = (BitmapDrawable) imgPreview.getDrawable();
    Bitmap bitmap = drawable.getBitmap();
    encodedImage = encodeToBase64(bitmap, Bitmap.CompressFormat.JPEG, 100);

    public static String encodeToBase64(Bitmap image, Bitmap.CompressFormat compressFormat, int quality)
    {
       ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
       image.compress(compressFormat, quality, byteArrayOS);
       return Base64.encodeToString(byteArrayOS.toByteArray(), Base64.DEFAULT);
    }
    
    
    
// decode:
Bitmap bitmap = decodeBase64(encodedImage );
img.setImageBitmap(bitmap);

public static Bitmap decodeBase64(String input)
{
    byte[] decodedBytes = Base64.decode(input,0);
    return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
 }
