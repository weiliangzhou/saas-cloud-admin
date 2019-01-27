package com.zwl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zwl.common.domain.Tree;
import com.zwl.common.utils.BuildTree;
import com.zwl.system.dao.MenuMapper;
import com.zwl.system.dao.RoleMapper;
import com.zwl.system.dao.UserMapper;
import com.zwl.system.domain.MenuDO;
import com.zwl.system.service.MenuService;
import com.zwl.system.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootdoApplicationTests {
	@Autowired
	UserMapper userMapper;
	@Autowired
	MenuMapper menuMapper;
	
	@Autowired
	RoleMapper RoleMapper;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	UserService userService;
	

	@Test
	public void contextLoads() {
		List<Tree<MenuDO>> trees = new ArrayList<Tree<MenuDO>>();
		List<MenuDO> menuDOs = menuMapper.listMenuByUserId(1L);
		for (MenuDO sysMenuDO : menuDOs) {
//			if (sysMenuDO.getParentId()>0) {
//				continue;
//			}
			Tree<MenuDO> tree = new Tree<MenuDO>();
			tree.setId(sysMenuDO.getMenuId().toString());
			tree.setParentId(sysMenuDO.getParentId().toString());
			tree.setText(sysMenuDO.getName());
			trees.add(tree);
			System.out.println(tree.getText() + "----" + tree.getId() + "----" + tree.getParentId());
		}
//		Tree<SysMenuDO> tree = new Tree<SysMenuDO>();
//		tree.setId("1");
//		tree.setParentId("");
//		tree.setText("Test");
//		Tree<SysMenuDO> tree = new Tree<SysMenuDO>();
//		tree.setId("0");
//		tree.setParentId("");
//		tree.setText("");
//		trees.add(tree);
		List<Tree<MenuDO>> t = BuildTree.buildList(trees,"0");
		System.out.println(t);
	}
 
	@Test
	public void test01() {
		Map<String, Object> map = new HashMap<>();
		map.put("username", "fff");
		boolean b = userService.exit(map);
		System.out.println(b);
	}

}