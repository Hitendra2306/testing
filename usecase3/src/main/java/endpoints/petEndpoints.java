package endpoints;
public class petEndpoints {
	public String BASE_URL = "https://petstore.swagger.io/v2";
	public String CREATE_PET = "/pet";
	public String FIND_PET = "/pet/findByStatus";

	public String GET_PET = "/pet/{petId}";
	public String UPDATE_PET = "/pet";
	public String DELETE_PET = "/pet/{petId}";
	public String UPLOAD_PET_IMAGE = "/pet/{petId}/uploadImage";
	public String getPetEndpoint(String petId) {
		return GET_PET.replace("{petId}", petId);
	}
	public String getDeletePetEndpoint(String petId) {
		return DELETE_PET.replace("{petId}", petId);
	}
	public String getUploadPetImageEndpoint(String petId) {
		return UPLOAD_PET_IMAGE.replace("{petId}", petId);
	}
}
