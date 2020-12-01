import React from "react";
import {Resource} from "react-admin";

import {RoleList} from './list';
import {RoleCreate} from './create';
import {RoleEdit} from './edit';
import {RoleShow} from './show';

export const Role = {list: RoleList, create: RoleCreate, edit: RoleEdit, show: RoleShow};
const RoleResource = <Resource options={{label: '角色'}} name="roles" {...Role} />;
export default RoleResource;
