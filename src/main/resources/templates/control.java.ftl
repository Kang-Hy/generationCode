package ${package.Controller};

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
*${table.controllerName}
*
* @author ${author}
* @since ${date}
*/

@RestController
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
public class ${table.controllerName} {

@Autowired
private ${table.serviceName} ${table.entityPath}Service;

/**
* 查询表${table.name}所有信息
*/
@GetMapping
public R
<List<${entity}>> findAll${entity}() {
return R.ok(${table.entityPath}Service.list());
}


/**
* 逻辑删除
* @param idEntity
*/
@DeleteMapping("/del")
public R delete${entity}ById(@RequestBody IdEntity idEntity) {
return ${table.entityPath}Service.removeById(idEntity.getId()) ? R.ok() : R.fail();
}


/**
* 根据id查询信息
* @param idEntity
*/
@PostMapping("/getById")
public R<${entity}> get${entity}ById(@RequestBody IdEntity idEntity) {
return R.ok(${table.entityPath}Service.getById(idEntity.getId()));
}

}
