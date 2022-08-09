# tflint-ignore: terraform_unused_declarations
variable "cluster_name" {
  description = "Name of cluster"
  type        = string
  default     = ""
}

variable "aws_region" {
  type = string
}