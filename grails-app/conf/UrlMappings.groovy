class UrlMappings {

	static mappings = {

        "/rest/boards"(controller: "board", action: [GET: "getAllBoards"])

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
