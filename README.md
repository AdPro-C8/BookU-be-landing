### Design Pattern
## Kenapa saya menggunakan design pattern observer?
# Jawabannya adalah karena pada suatu landing page kita memerlukan data dari beberapa instance seperti Book dan User profile. 
# Ketika terjadi suatu perubahan secara terus-menerus pada data yang dimiliki oleh Book dan User, seharusnya landing page tidak perlu menanyakan terus menerus kepada Book dan User terkait perubahan yang dilakukan.
# Pada kasus ini Objek Book akan terus mengalami perubahan seperti penambahan buku baru, edit atribut, penambahan review baru dari suatu buku, dsb.
# Oleh karena itu, Book akan memiliki one to many relationship dimana ia akan menotifikasi Objek lain yang bergantung pada datanya jika terdapat perubahan pada objek Book.


## Apakah ada design pattern lain yang terpikirkan untuk digunakan di landing page ini?
# Ya, ada beberapa design pattern lain yang saya pertimbangkan seperti `facade pattern` dan `adapter pattern`. Alasannya adalah karena facade akan berusaha menyembunyikan implementasi yang rumit dari suatu kode yang diperoleh dari kode lain.
