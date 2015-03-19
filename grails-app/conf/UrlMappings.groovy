class UrlMappings {

	static mappings = {

        "/rest/boards"(controller: "board", action: [GET: "getAllBoards"])
        "/rest/boards/$id"(controller: "board", action: [GET: "getBoard2"])
        "/rest/health"(controller: "board", action: "health")
        "/rest/user/register"(controller: "user", action: [POST: "register"])
        "/rest/user/$username"(controller: "user", action: [GET: "getUser"])

        "/rest/order"(controller: "order", action: [GET: "getOrder"])
        "/rest/order/save"(controller: "order", action: [POST: "saveOrder"])

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
