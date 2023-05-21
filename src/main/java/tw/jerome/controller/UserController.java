package tw.jerome.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import tw.jerome.domain.entity.User;
import tw.jerome.domain.repository.UserRepository;

@Tag(name = "會員")
@RestController
public class UserController {
	@Autowired
	private UserRepository UserRepository;

	@Operation(summary = "取得所有會員", description = "取得所有會員資料，每次上限 1000 筆")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Success",content = {
	        		@Content(mediaType = "application/json",array = @ArraySchema(schema = @Schema(implementation = User.class)))
	        }),
	        @ApiResponse(responseCode = "401", description = "參數錯誤或沒有權限", content = {
	                @Content()
	        })
	})
	
	@GetMapping("/user/all")
	public ResponseEntity<List<Map<String, Object>>> getAllUser(
			@Parameter(description = "會員編號", example = "1") Long id,
			@Parameter(description = "會員名稱", example = "Jerome") String name
	)
	
	{
		List<User> userData = UserRepository.findAll();
		List<Map<String, Object>> list = new ArrayList<>();
		for(User data:userData) {
			list.add(data.dataToMap());
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@Operation(summary = "新增會員", description = "新增會員資料")
	@PostMapping("/user")
	public Map<String, String> createUser() 
	{
		Map<String, String> map = new HashMap<String,String>();
		return map;
	}
	
	@Operation(summary = "更新會員資料", description = "更新指定會員資料")
	@PutMapping("/user/{username}")
	public Map<String, String> updateUser() 
	{
		Map<String, String> map = new HashMap<String,String>();
		return map;
	}
	
	@Operation(summary = "刪除會員", description = "刪除指定會員資料")
	@DeleteMapping("/user/{username}")
	public Map<String, String> deleteUser() 
	{
		Map<String, String> map = new HashMap<String,String>();
		return map;
	}

}
