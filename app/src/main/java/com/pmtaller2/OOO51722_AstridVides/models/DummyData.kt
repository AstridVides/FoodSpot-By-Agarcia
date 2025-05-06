package com.pmtaller2.OOO51722_AstridVides.models

val restaurant = listOf(
    Restaurant(
        id = 1,
        name = "Pizza Planet",
        description = "Las mejores pizzas del universo",
        imageUrl = "https://cdn.unotv.com/images/2024/09/pizza-pepperoni-no-existe-italia-152140-1024x576.jpeg",
        categories = listOf("Comida Rápida", "Comida Italiana"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Pizza Pepperoni",
                description = "Clásica pizza con pepperoni y queso.",
                imageUrl = "https://cdn.unotv.com/images/2024/09/pizza-pepperoni-no-existe-italia-152140-1024x576.jpeg"
            ),
            Dish(
                id = 2,
                name = "Pizza Vegetariana",
                description = "Pizza saludable con verduras frescas.",
                imageUrl = "https://hoytoca-cms.ext-sites-prd.cloudherdez.com/assets/b0d29d09-852e-42e1-9e66-b486a01e25a3"
            ),
            Dish(
                id = 3,
                name = "Pizza triple queso",
                description = "Pizza con un delicioso triple queso.",
                imageUrl = "https://www.hola.com/horizon/square/e017ddebc2bc-pizzacuatroquesos-adob-t.jpg?im=Resize=(640),type=downsize"
            )
        )
    ),
    Restaurant(
        id = 2,
        name = "Burger King Kong",
        description = "Las mejores hamburguesas monstrosas",
        imageUrl = "https://i.pinimg.com/736x/5a/dd/ef/5addef717393e460c088628843b18db8.jpg",
        categories = listOf("Comida Rápida"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Hamburguesa doble queso",
                description = "Doble carne, doble queso, doble sabor.",
                imageUrl = "https://i.pinimg.com/736x/5a/dd/ef/5addef717393e460c088628843b18db8.jpg"
            ),
            Dish(
                id = 2,
                name = "Hamburguesa Vegana",
                description = "Una opción delisiosa y saludable.",
                imageUrl = "https://www.larecetafacil.com/wp-content/uploads/2023/08/hamburguesas-veganas-receta.jpg"
            ),
            Dish(
                id = 3,
                name = "Hamburguesa Bacon",
                description = "Una bacon el sabor que necesitas.",
                imageUrl = "https://www.cocinadelirante.com/sites/default/files/styles/gallerie/public/images/2024/06/hamburguesa-con-tocino.jpg"
            )
        )
    ),Restaurant(
        id = 3,
        name = "Taquitos",
        description = "Un taco bien hecho es un poema envuelto en tortilla.",
        imageUrl = "https://www.pequerecetas.com/wp-content/uploads/2020/10/tacos-mexicanos.jpg",
        categories = listOf("Comida Mexicana"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Tacos de pastor",
                description = "Taquito con pastor lleno de mucho sabor",
                imageUrl = "https://www.pequerecetas.com/wp-content/uploads/2020/10/tacos-mexicanos.jpg"
            ),
            Dish(
                id = 2,
                name = "Taco vegano",
                description = "Taco saludable con verduras frescas.",
                imageUrl = "https://cdn.recetasderechupete.com/wp-content/uploads/2020/01/tacos-veganos.jpg"
            ),
            Dish(
                id = 3,
                name = "Taco de Birria",
                description = "Tacos llenos de birria a compañado con su salsa.",
                imageUrl = "https://www.mccormick.com/-/media/project/oneweb/mccormick-us/el-guapo/recipes/800x800/beef_birra_tacos_ground_black_pepper_800x800.jpg?rev=e42c1fb5716547f489920ad0e765427a&vd=20211208T213909Z&extension=webp&hash=EB7CE59B96A81D047EF25115F1FFEEA8"
            )

        )
    ),
    Restaurant(
        id = 4,
        name = "Tortas",
        description = "Una torta deliciosa es como un abrazo de sabor.",
        imageUrl = "https://mexicorutamagica.mx/wp-content/uploads/2020/03/1434.jpg",
        categories = listOf("Comida Mexicana"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Torta ahogada",
                description = "Una torta que te ahoga de buen sabor.",
                imageUrl = "https://mexicorutamagica.mx/wp-content/uploads/2020/03/1434.jpg"
            ),
            Dish(
                id = 2,
                name = "Torta Vegana",
                description = "Torta saludable con verduras frescas.",
                imageUrl = "https://www.acalastortas.com.mx/wp-content/uploads/2017/06/tortoa-vegetariana.jpg"
            ),
            Dish(
                id = 3,
                name = "Torta de birria",
                description = "Torta de birria y su salsa que no puede quedar atrás.",
                imageUrl = "https://birria-truck.com/wp-content/uploads/2023/08/birria_torta.jpg"
            )
        )
    ),
    Restaurant(
        id = 5,
        name = "PastariasClub",
        description = "La pasta es capaz de hacer cantar a tu paladar.",
        imageUrl = "https://recetasdecocina.elmundo.es/wp-content/uploads/2025/01/espaguetis-a-la-napolitana-1024x683.jpg",
        categories = listOf("Comida Italiana"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Espaguetis a la napolitana",
                description = "Pasta que se prepara típicamente con tomates frescos.",
                imageUrl =  "https://recetasdecocina.elmundo.es/wp-content/uploads/2025/01/espaguetis-a-la-napolitana-1024x683.jpg"
            ),
            Dish(
                id = 2,
                name = "Spicy Penne",
                description = "La pasta más deliciosa de pennes.",
                imageUrl = "https://s.lightorangebean.com/media/20240914160809/Spicy-Penne-Pasta_-done.png"
            ),
            Dish(
                id = 3,
                name = "Espaguetis al limón",
                description = "Una conbinacion perfecta para sentirte en italí.",
                imageUrl = "https://www.petitchef.es/imgupl/recipe/espaguetis-al-limon-la-verdadera-receta-italiana-de-la-pasta-al-limone--463498p733622.jpg"
            )
        )
    ),
    Restaurant(
        id = 6,
        name = "Sushi Rolls",
        description = "Cada bocado de sushi es un pequeño viaje al corazón de Japón.",
        imageUrl =  "https://images.squarespace-cdn.com/content/v1/67d1d0d895d7ed34764032b3/08f692c4-edb6-4e1f-8d12-9967f17588bd/Adobe+Express+-+file.jpg",
        categories = listOf("Comida asiática"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Sushi de salmón",
                description = "Sushi rolls de salmón y olivada negra.",
                imageUrl = "https://www.oliveradatenea.com/wp-content/uploads/2023/06/Sushi-rolls-de-salmon-y-Olivada-Olivera-dAtenea.jpg"
            ),
            Dish(
                id = 2,
                name = "Sushi vegano",
                description = "Sushi crujiente frito con tempura vegano.",
                imageUrl = "https://www.kikkoman.es/fileadmin/_processed_/9/0/csm_1414_Vegan_Tempura_Sushi_Desktop_Header_148b8761b6.jpg"
            ),
            Dish(
                id = 3,
                name = "Sushi gama",
                description = "Sushi especialmente el pescado, son alabados por su frescura y calidad.",
                imageUrl = "https://tofuu.getjusto.com/orioneat-prod/DsjGEsB9nDHLgJvqN-160300378_2736439523338426_6052926231888734866_n.jpg"
            )
        )
    ),Restaurant(
        id = 7,
        name = "Banbon",
        description = "Los postres son el abrazo dulce que tu paladar merece.",
        imageUrl = "https://www.paulinacocina.net/wp-content/uploads/2024/01/receta-de-postre-de-maracuya-Paulina-Cocina-Recetas-1722251880-1200x676.jpg",
        categories = listOf("Postres y Dulces"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Postre de maracuya",
                description = "Postre de maracuya delicioso y fresco.",
                imageUrl = "https://www.paulinacocina.net/wp-content/uploads/2024/01/receta-de-postre-de-maracuya-Paulina-Cocina-Recetas-1722251880-1200x676.jpg"
            ),
            Dish(
                id = 2,
                name = "Pastel toxico",
                description = "Toxico de chocolate delicioso y disfrutante.",
                imageUrl = "https://www.suqiee.com.mx/wp-content/uploads/2022/12/web-pastel-de-chocolate-1-1200x600.jpg"
            ),
            Dish(
                id = 3,
                name = "Mona de pascua",
                description = "Pastel de fresa con coco y con ese toque de merengue.",
                imageUrl = "https://content-cocina.lecturas.com/medio/2021/05/17/paso_a_paso_para_realizar_mona_de_pascua_de_fresa_con_coco_y_merengues_resultado_final_da1c7a67_1200x1200.jpg"
            )
        )
    ),
    Restaurant(
        id = 8,
        name = "BubblesKING",
        description = "Bubble Tea, una bebida refrescante y divertida.",
        imageUrl = "https://veggiefestchicago.org/wp-content/uploads/2021/05/21-bumble.jpg",
        categories = listOf("Bebidas"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Bubble de taro",
                description = "Bubble tea de taro con tapioca deliciosa y resfrescante.",
                imageUrl = "https://kreamyvegan.com/wp-content/uploads/2024/09/240917_taro-bubble-tea-recipe-with-real-fresh-taro_taro-latte.jpg"
            ),
            Dish(
                id = 2,
                name = "Bubble de matcha green",
                description = "Matcha boba tea con tapioca muy refrescante.",
                imageUrl = "https://greenheartlove.com/wp-content/uploads/2023/05/matcha-boba-tea-5.jpg"
            ),
            Dish(
                id = 3,
                name = "Butterfly pea flower tea",
                description = "Pizza saludable con verduras frescas.",
                imageUrl = "https://cornercoffeestore.com/wp-content/uploads/2022/07/two-glasses-of-butterfly-pea-milk-tea-with-pearls_Elena-Veselova_Shutterstock.jpg"
            )
        )
    )
)