sealed interface ApiResponse {
    data class SuccessResponse(val data: String) : ApiResponse

    data class ErrorResponse(val errorCode: Int, val errorMessage: String) : ApiResponse

    object Loading : ApiResponse
}

fun handleResponse(response: ApiResponse) {
    when (response) {
        is ApiResponse.SuccessResponse -> println("Respuesta recibida: ${response.data}")
        is ApiResponse.ErrorResponse ->
            println("Error ${response.errorCode}: ${response.errorMessage}")
        ApiResponse.Loading -> println("Cargando respuesta...")
    }
}

fun main() {
    handleResponse(ApiResponse.Loading)
    handleResponse(ApiResponse.SuccessResponse("{\"user\": \"Ada\"}"))
    handleResponse(ApiResponse.ErrorResponse(404, "Not Found"))
}
