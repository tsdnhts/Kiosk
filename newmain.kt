fun main(args: Array<String>) {

    // 메뉴 보드 리스트
    var menuList = arrayOf(MenuBoard("햄버거", 1), MenuBoard("사이드 메뉴", 2),
        MenuBoard("세트 메뉴", 3), MenuBoard("디저트", 4))

    addMenus(menuList) // 메뉴 추가.

    // 키오스크 전체 프로그램.
    while(true)
    {
        println("맥도날드")
        // 메뉴 보드 정보를 보여줌.
        for(menuBoard in menuList)
        {
            menuBoard.displayMenuBoardInfo()
        }
        // 보드 선택 입력
        var boardSelection: Int = 0
        try {
            boardSelection = readln().toInt()
        } catch (e : java.lang.NumberFormatException)
        {
            // 숫자가 아니면 다시.
            println("메뉴 종류 번호를 입력하세요.")
            continue
        }
        if(boardSelection !in 1 .. menuList.size)
        {
            // 1 ~ 메뉴 사이즈 사이 번호가 아니면 다시.
            println("유효하지 않은 번호입니다.")
            continue
        }

        // 메뉴 선택 프로그램.
        while (true)
        {
            // 메뉴 정보 보여줌.
            menuList[boardSelection- 1].displayMenu()
            // 메뉴 선택 입력.
            var menuSelection: Int = 0
            try {
                menuSelection = readln().toInt()
            } catch (e : java.lang.NumberFormatException)
            {
                // 숫자가 아니면 다시.
                println("메뉴 종류 번호를 입력하세요.")
                continue
            }
            if(menuSelection !in 1 .. menuList[boardSelection - 1].getMenuSize())
            {
                // 1 ~ 메뉴 보드에 등재된 메뉴 리스트 사이즈가 아니면 다시.
                println("유효하지 않은 번호입니다.")
                continue
            }
            // 끝.
            break
        }
        println("프로그램을 종료합니다.")
        break
    }

}

fun addMenus(menuList: Array<MenuBoard>)
{
    // 햄버거 메뉴 추가.
    menuList[0].addMenu(hamburger(5500, "빅맥", 40, "순 소고기 패티 2장에 치즈와 신선한 양상추, 양파, 그리고 피클까지", 5))
    menuList[0].addMenu(hamburger(5700, "1955버거", 20, "더 풍성해진 신선한 양상추와 깊은 풍미의 그릴드 어니언까지)", 4))
    menuList[0].addMenu(hamburger(5300, "베이컨 토마토 디럭스", 30, "두장의 순 쇠고기 패티에 신선한 토마토와 양상추", 2))
    menuList[0].addMenu(hamburger(5000, "쿼터파운드 치즈", 15, "두배이상 커진 비프와 부드러운 치즈 두장의 환상 궁합", 3))
    menuList[0].addMenu(hamburger(2000, "불고기 버거", 10, "한국인의 입맛에 맞는 불고기 소스에 잘 재운 패티", 2))
    menuList[0].addMenu(hamburger(5600, "맥스파이시 상하이 버거", 10, "닭가슴 통살 위 아삭아삭한 양상추와 신선한 토마토", 3))
    // 사이드 메뉴 추가
    menuList[1].addMenu(sidemenu(3000, "맥너겟", 20, "바삭하고 촉촉한 치킨이 입안에 쏙", 1))
    menuList[1].addMenu(sidemenu(4900, "맥 스파이시 치킨 텐더", 10, "닭 안심살을 스파이시 시즈닝으로 매콤 바삭하게 튀겨낸 치킨 텐더)", 1))
    menuList[1].addMenu(sidemenu(3900, "골든 모짜렐라 치즈 스틱", 30, "속이 꽉 찬 황금빛 바삭함", 1))
    menuList[1].addMenu(sidemenu(2800, "후렌치 후라이", 10, "통으로 썰어낸 감자를 맥도날드만의 노하우로 튀겨낸 월드 클래스 후렌치 후라이", 1))

    // 세트 메뉴 추가
    menuList[2].addMenu(setmenu(5500, "빅맥 세트", 100, "빅맥 세트", 3))
    menuList[2].addMenu(setmenu(5700, "1955버거 세트", 100, "1955버거 세트", 3))
    menuList[2].addMenu(setmenu(5300, "베이컨 토마토 디럭스 세트", 100, "베이컨 토마토 디럭스 세트", 3))
    menuList[2].addMenu(setmenu(5000, "쿼터파운드 치즈 세트", 10, "쿼터파운드 치즈 세트", 3))
    menuList[2].addMenu(setmenu(2000, "불고기 버거 세트", 120, "불고기 버거 세트", 3))
    menuList[2].addMenu(setmenu(5600, "맥스파이시 상하이 버거 세트", 100, "맥스파이시 상하이 버거 세트", 3))

    // 디저트 메뉴 추가
    menuList[3].addMenu(setmenu(2500, "오레오 맥플러리", 150, "우유 듬뿍 신선한 아이스크림", 3))
    menuList[3].addMenu(setmenu(2500, "딸기 오레오 맥플러리", 150, "상큼한 딸기와 달콤한 오레오 쿠키가 신선한 우유 아이스크림에 퐁당", 3))
    menuList[3].addMenu(setmenu(2500, "초코 오레오 맥플러리", 150, "초콜릿 피치와 오레오 쿠키까지 달달함이 두배로", 3))
    menuList[3].addMenu(setmenu(700, "아이스크림 콘", 150, "신선한 우유로 만든 부드러운 아이스크림 콘", 3))
    menuList[3].addMenu(setmenu(900, "초코콘", 150, "달달한 초콜릿 옷을 입은 소프트 아이스크림", 3))
    menuList[3].addMenu(setmenu(3000, "오레오 아포가토", 150, "진한 에스프레소에 바닐라 아이스크림으로 달콤쌉쌀하게, 오레오 쿠키로 바삭함까지", 3))
}