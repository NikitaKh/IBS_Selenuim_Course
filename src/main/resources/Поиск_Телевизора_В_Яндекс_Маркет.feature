#language: ru

Функционал: Яндекс Маркет

  Сценарий: Поиск телевизора

    Когда выбран пункт меню "Маркет"
    И выбран раздел каталога "Электроника"
    Тогда выбран вид товара - "Телевизоры"
    И выполнен переход во 'Все фильтры'
    Когда задать параметры поиска по цене "от" "20000"
    И выбрать производителей:
      |LG|
      |Samsung|
    Тогда нажать кнопку 'Применить'
    И количество элементов на странице равно - "12"
    Когда записана информация о "1" элементе
    Тогда в поисковую строку введено записанное значение и нажата кнопка 'Найти'
    И наименование товара соответствует запомненному значению

    