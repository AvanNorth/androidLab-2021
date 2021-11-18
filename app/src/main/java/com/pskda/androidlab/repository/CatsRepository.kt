package com.pskda.androidlab.repository

import com.pskda.androidlab.model.Cats

object CatsRepository {
    var id = 0
    val cats = arrayListOf(
        Cats(
            id,
            "Lenny",
            "very clever and beautiful cat",
            listOf(
                "https://96.img.avito.st/640x480/447652196.jpg",
                "https://lh3.googleusercontent.com/proxy/kqKEk4ByO4COXqDcbFgbu1BLStAuO2b6HYjbY-Z_x_LvCXKlGLmaSfBClj851hFp_PyNRosCZa57brjvqcMTDW7qYcOafy71IKsXXPOwqyZ2M2v_YgaT0hMrv8PBcN_gUMSP",
                "https://s9.travelask.ru/uploads/post/000/018/168/main_image/full-52a521fd70f4785d1346cb36748815cd.jpg"
            )
        ),
        Cats(
            id++,
            "Misha",
            "lazy but smart cat",
            listOf(
                "https://www.kartinki24.ru/uploads/gallery/main/55/kartinki24_ru_cats_84.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQRuoZL2TpPCMaEBY4bUHna92Q6jRIMyMtBb6zd7PzzCP1XS7olrW0z-40R5-xBSP6i5xc&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT0EV4E7pclOYlZl_j_eVlT4eSnaMScPZvlJuLI9qy93GeP6e4N1nYQhJhgE1i4_naLVmc&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTEyczGGI5ICN1W8LFOlWvxs6qcumTLrryymA&usqp=CAU"
            )
        ),
        Cats(
            id++,
            "Boris",
            "A very active cat. What is his secret?",
            listOf(
                "https://avatars.mds.yandex.net/get-zen_doc/1661927/pub_5e2ffc4abd639600b209c100_5e2ffe8e0a451800adad66fe/scale_1200",
                "https://images.radiokp.ru/sites/default/files/styles/kp_fullnode_730_486/public/2020-11/1_9.png?itok=bdxN0EsN",
                "https://76.img.avito.st/640x480/10010174076.jpg",
            )
        )
    )
}