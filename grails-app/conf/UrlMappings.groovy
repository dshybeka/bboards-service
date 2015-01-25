class UrlMappings {

	static mappings = {

        "/rest/boards"(controller: "board", action: [GET: "getAllBoards"])
        "/rest/boards/$id"(controller: "board", action: [GET: "getBoard"])

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
