package io.appwrite

/**
 * Helper class to generate permission strings for resources.
 */
class Permission {
    companion object {

        /**
         * Generate read permission string for the provided role.
         *
         * @param role The role for which to generate the permission.
         * @returns The read permission string.
         */
        fun read(role: String): String {
            return "read(\"${role}\")"
        }   

        /**
         * Generate write permission string for the provided role.
         *
         * This is an alias of update, delete, and possibly create.
         * Don't use write in combination with update, delete, or create.
         *
         * @param role The role for which to generate the permission.
         * @returns The write permission string.
         */
        fun write(role: String): String {
            return "write(\"${role}\")"
        }        
        
        /**
         * Generate create permission string for the provided role.
         *
         * @param role The role for which to generate the permission.
         * @returns The create permission string.
         */
        fun create(role: String): String {
            return "create(\"${role}\")"
        }    
        
        /**
         * Generate update permission string for the provided role.
         *
         * @param role The role for which to generate the permission.
         * @returns The update permission string.
         */
        fun update(role: String): String {
            return "update(\"${role}\")"
        }     
        
        /**
         * Generate delete permission string for the provided role.
         *
         * @param role The role for which to generate the permission.
         * @returns The delete permission string.
         */
        fun delete(role: String): String {
            return "delete(\"${role}\")"
        }        
    }
}
